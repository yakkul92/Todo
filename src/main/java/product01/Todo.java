package product01;

import java.util.*;
import java.io.*;

public class Todo{
    public static void main(String[] args) throws Exception{
    }
  }
  class ToDo{
    // フィールド
    String title;
    int importance;

    // コンストラクタ
    ToDo(String title, int importance){
        this.title = title;
        this.importance = importance;
    }
    
    // インスタンスメソッド
    String showStatus(){
        return String.format("%s/重要度:%d", this.title, this.importance);
    }
    void changeImportance(int importance){
        this.importance = importance;
        System.out.println("重要度を変更しました。");
    }
  }