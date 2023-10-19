package com.sunwenyi;

import java.net.InetSocketAddress;
import java.util.List;


import com.alibaba.fastjson2.JSONObject;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.InetSocketAddress;

public class canalclient {

    public static void main(String[] args) throws InvalidProtocolBufferException, InterruptedException {
        //TODO 获取连接
        CanalConnector canalConnector =CanalConnectors.newSingleConnector(new InetSocketAddress("20.62.165.173",11111),
                "example","","");

        while(true){
            //TODO 连接
            canalConnector.connect();

            //TODO 订阅数据库
            canalConnector.subscribe("canal.*");

            //TODO 获取数据
            Message message = canalConnector.get(100);

            //TODO 获取entry集合
            List<CanalEntry.Entry> entries = message.getEntries();

            //TODO 判断集合是否为空，如果为空，则等待一会继续拉取数据
            if(entries.size()<=0){
                System.out.println("No data yet....");
                Thread.sleep(1000);
            }else{
                //TODO 遍历entries,单条解析
                for(CanalEntry.Entry entry: entries){
                    //1.获取表名
                    String tablename = entry.getHeader().getTableName();

                    //2。获取类型
                    CanalEntry.EntryType entryType = entry.getEntryType();

                    //3。获取序列化后的数据
                    ByteString storeValue = entry.getStoreValue();

                    //4. 判断当前Entrytype类型是否为ROWDATA
                    if (CanalEntry.EntryType.ROWDATA.equals(entryType)){
                        //5. 反序列化数据
                        CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(storeValue);

                        //6. 获取当前事件的操作类型
                        CanalEntry.EventType eventType = rowChange.getEventType();

                        //7. 获取数据集
                        List<CanalEntry.RowData> rowDataList = rowChange.getRowDatasList();

                        //8. 遍历rowDataList,打印数据集
                        for (CanalEntry.RowData rowData : rowDataList){
                            JSONObject beforeData = new JSONObject();

                            List<CanalEntry.Column> beforeColumnList = rowData.getBeforeColumnsList();

                            for (CanalEntry.Column column : beforeColumnList){
                                beforeData.put(column.getName(),column.getValue());
                            }

                            JSONObject afterData = new JSONObject();
                            List<CanalEntry.Column> afterColumnList = rowData.getAfterColumnsList();

                            for (CanalEntry.Column column : afterColumnList){
                                afterData.put(column.getName(),column.getValue());
                            }

                            System.out.println("Table: "+tablename+", Eventtype: "+eventType+
                                    ",before: "+beforeData+
                                    ",after: "+afterData);

                        }



                    }else {
                        System.out.println("当前数据类型为："+entryType);
                    }


                }

            }


        }










    }
}
