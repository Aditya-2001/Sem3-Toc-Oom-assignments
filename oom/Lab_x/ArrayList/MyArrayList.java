package  mypac;

public class MyArrayList<V> {

    //Since we are implementing arraylist using array so its fix_size has to be defined
    private static final int fix_size=10;

    //recordArray is a array of Object type
    private Object recordArray[];

    //index is the original size of arraylist and size is the max size of recordArray
    private int index,size;

    //Default Constructor
    public MyArrayList(){
        recordArray=new Object[fix_size];
        this.size=fix_size;
    }

    //Method to add an element in the recordArray which will also check size bound of array
    public void add(V v){
        if(this.index==this.size-1){
            //we need to increase the size of recordArray[]
            increaseSize();
        }
        recordArray[this.index]=v;
        this.index++;

    }

    //Private method to handle size bound of the array
    private void increaseSize() {
        this.size=this.size+fix_size;
        Object newrecordArray[]=new Object[this.size];
        for(int i=0; i<recordArray.length;i++){
            newrecordArray[i]=recordArray[i];
        }
        this.recordArray=newrecordArray;
    }

    //Method to get the element of recordArray at ith index
    //Note: Different from original ArrayList since it will also work for indexes out of range
    public V get(int i){
        i=i%index;
        final V v = (V)recordArray[i];
        return v;

    }

    //Method to remove an element of recordArray from ith index\
    //Note: Different from original ArrayList since it will also work for indexes out of range
    public void remove(int i){
        i=i%index;
        for(int x=i; x<this.recordArray.length-1;x++){
            recordArray[x]=recordArray[x+1];
        }
        this.index--;
    }

    //Method to set the value of element at given index
    //Note: Different from original ArrayList since it will also work for indexes out of range
    public void set(Integer i,V v){
        i=i%index;
        recordArray[i]=v;
    }

    //Method to clear all the elements in the array
    public void clear(){
        index=0;
        size=fix_size;
    }

    //Method to return the size of ArrayList
    public int size(){
        return index;
    }

    //Method to display all the elements in the ArrayList
    public void display(){
        for(int i=0;i<this.index;i++){
            System.out.print(recordArray[i]);
            if(i!=this.index-1)
                System.out.print(",  ");
        }
        System.out.println();
    }
}