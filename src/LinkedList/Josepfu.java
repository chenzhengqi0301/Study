package LinkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedlist circleSingleLinkedlist = new CircleSingleLinkedlist();
        circleSingleLinkedlist.addBoy(125);
        circleSingleLinkedlist.listBoy();
        circleSingleLinkedlist.countBoy(10,20);
        System.out.println();
        circleSingleLinkedlist.listBoy();
    }
}
class CircleSingleLinkedlist{
    Boy firstBoy=new Boy(-1);

    public void addBoy(int num){
        if(num<1) return;
        Boy curBoy = null;
        for(int i=1;i<=num;i++){
            if(i==1){
                firstBoy.setNum(i);
                firstBoy.next=firstBoy;
                curBoy=firstBoy;
            }else{
                Boy nowBoy = new Boy(i);
                curBoy.next=nowBoy;
                nowBoy.next=firstBoy;
                curBoy=nowBoy;
            }
        }
    }

    public void listBoy(){
        Boy curBoy = firstBoy;
        while(true){
            if(curBoy.next==firstBoy){
                System.out.println(curBoy.num);
                break;
            }else {
                System.out.println(curBoy.num);
                curBoy=curBoy.next;
            }
        }
    }

    /**
     *
     * @param startNum  开始的小孩编号
     * @param countNum  数几次剔除一个小孩
     */
    public void countBoy(int startNum,int countNum){
        int num=getNum();
        if(startNum>num||startNum<1){
            System.out.println("输入有误");
        }
        for (int i=0;i<startNum-1;i++){
            firstBoy=firstBoy.next;
        }
        Boy helpBoy=firstBoy;
        for (int i=0;i<num-1;i++){
            helpBoy=helpBoy.next;
        }
        while(helpBoy!=firstBoy){
            for(int i=0;i<countNum-1;i++){
                helpBoy=helpBoy.next;
                firstBoy=firstBoy.next;
            }
            firstBoy=firstBoy.next;
            helpBoy.next=firstBoy;
        }
    }

    public int getNum(){
        int num = 1;
        Boy curBoy=firstBoy;
        while (true){
            if(curBoy.next==firstBoy) break;
            else{
                curBoy=curBoy.next;
                num++;
            }
        }
        return num;
    }
}


class Boy{
    int num;
    Boy next;

    public Boy(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}