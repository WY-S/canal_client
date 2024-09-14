package link;

public class LinkRun {
    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(5);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        //System.out.println(list.findElem(list.head, 3).data);
        //list.orderList();
        //list.deleteDuplecate(list.head);
        System.out.println(list.IsLoop(list.head));
        //list.printList();

    }
}
