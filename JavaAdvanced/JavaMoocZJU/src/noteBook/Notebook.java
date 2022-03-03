package noteBook;

import java.util.ArrayList;

/**
 * @author filwsx
 * @date 2022-03-03 13:34
 */
public class Notebook {
    //翁恺老师使用Arraylist of String 来解释泛型，绝了！！
    //泛型与容器的概念密不可分！
    private ArrayList<String> notes = new ArrayList<String>();
    //private int size = 0;

    public boolean add (String s){
        //size++;
        return notes.add(s);
    }

    public int getSize(){
        return notes.size();
    }

    public String getNote(int index){
        index --;   //符合用户直觉
        if(index < getSize() && index > 0){
            return notes.get(index);
        }
        else{
            return "索引无效";
        }
    }

    public void removeNote(int index){
        //size--;
        index--;
        notes.remove(index);
    }

    public String[] list(){
        String [] result = new String[notes.size()];
//        for (int i = 0; i < notes.size(); i++) {
//            result[i] = notes.get(i);
//        }
        notes.toArray(result);
        return result;
    }
}
