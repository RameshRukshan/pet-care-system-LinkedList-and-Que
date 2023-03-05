/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pet.care.sys;

/**
 *
 * @author Ramesh
 */

class CNode{
    Checkup checkup;
    CNode next, pre;
    
    public CNode(Checkup checkup){
        this.checkup = checkup;
        next=null;
        pre=null;
    }
}

public class CheckupList {
    CNode head, tail;
    
    public CheckupList(){
        head=null;
        tail=null;
    }
    
    public void Enqueue(Checkup checkup){
        CNode node = new CNode(checkup);
        if(head==null || tail==null){
            head = node;
            tail = node;
        }else if(head.checkup.getPriority() < checkup.getPriority()){
            head.next = node;
            node.pre = head;
            head = node;
        }else if(tail.checkup.getPriority() >= checkup.getPriority()){
            tail.pre = node;
            node.next = tail;
            tail = node;
        }else{
            CNode temp = tail;
            while(temp != null){
                if(temp.checkup.getPriority() >= checkup.getPriority()){
                    break;
                }
                temp = temp.next;
            }
            node.next = temp;
            node.pre = temp.pre;
            temp.pre.next = node;
            temp.pre = node;
        }
    }
    
   public Checkup dequeue()
    {if(head==null)
      {return null;
      }
     CNode  Checkup=head;
     head=head.next;
     return Checkup.checkup;
    }
    
    public void print()
    {
        CNode temp=head;
        while(temp !=null)
        {
            System.out.print("Priority is : ");
            System.out.println(temp.checkup.getPriority());
            temp=temp.pre;   
        }
    }
}
