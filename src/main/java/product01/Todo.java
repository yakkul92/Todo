package product01;

import java.util.*;
import java.io.*;

public class Todo{
    public static void main(String[] args) throws Exception{
    }
  }
  class ToDo{
    // �t�B�[���h
    String title;
    int importance;

    // �R���X�g���N�^
    ToDo(String title, int importance){
        this.title = title;
        this.importance = importance;
    }
    
    // �C���X�^���X���\�b�h
    String showStatus(){
        return String.format("%s/�d�v�x:%d", this.title, this.importance);
    }
    void changeImportance(int importance){
        this.importance = importance;
        System.out.println("�d�v�x��ύX���܂����B");
    }
  }