/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pet.care.sys;

/**
 *
 * @author Ramesh
 */

class PNode{
    Pet pet;
    PNode next, pre;

    public PNode() {
    }

    public PNode(Pet pet) {
        this.pet = pet;
        next=null;
        pre=null;
    }
}

public class PetList {
    
    PNode head, tail;
    
    public PetList(){
        head=null;
        tail=null;
    }
    
    public void Insert(Pet pet){
        PNode node = new PNode(pet);
        
        if(head==null || tail == null){
            head = node;
            tail = node;
        }else{
            head.next=node;
            node.pre = head;
            head = node;
        }
        
    }
    
    public Pet SearchByID(String id){
        PNode temp = head;
        
        while(temp!=null){
            if(temp.pet.getId().equals(id)){
                return temp.pet;
            }
            temp = temp.pre;
        }
        return null;
    }
    
    public Pet SearchByContact(String contact){
        PNode temp = head;
        
        while(temp!=null){
            if(temp.pet.getPet_owener_contact().equals(contact)){
                return temp.pet;
            }
            temp = temp.pre;
        }
        return null;
    }
}