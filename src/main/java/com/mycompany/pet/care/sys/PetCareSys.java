/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pet.care.sys;

/**
 *
 * @author Ramesh
 */

public class PetCareSys {

    public static void main(String[] args) {
        Pet pet1 = new Pet("111","Ramesh","7639");
        Pet pet2 = new Pet("112","FUJGHDF","763469");
        Pet pet3 = new Pet("113","RamHVesh","763469");
        
        PetList plist = new PetList();
        plist.Insert(pet1);
        plist.Insert(pet2);
        plist.Insert(pet3);
        /*
        System.out.println(plist.SearchByID("112").getPet_owner_name());
        System.out.println(plist.SearchByID("111").getPet_owener_contact());
        
        System.out.println(plist.SearchByContact("7639").getPet_owner_name());
        System.out.println(plist.SearchByContact("7639").getPet_owener_contact());
        */
        Veterinarian vet1 = new Veterinarian("20202","FHGD","6735474","yfjhef",2000);
        Veterinarian vet2 = new Veterinarian("20203","HVJ","635438","hdfg",2200);
        Veterinarian vet3 = new Veterinarian("20204","GJDF","6543","dsfyig",2500);
        
        VeterinarianList vlist = new VeterinarianList();
        vlist.Insert(vet1);
        vlist.Insert(vet2);
        vlist.Insert(vet3);
        
        //System.out.println(vlist.SearchByID("20202").getName());
        //System.out.println(vlist.SearchByID("20202").getSpeciality());
        
        //vlist.AllVeterinarianInfo();
        
        CheckupList checkuplist = new CheckupList();
        Checkup  checkup = new Checkup(vet1,pet1,1,"A","55");
        Checkup  checkup2 = new Checkup(vet1,pet2,10,"A","55");
        Checkup  checkup3 = new Checkup(vet1,pet2,5,"A","55");
        Checkup  checkup4 = new Checkup(vet1,pet2,9,"A","55");
        
        checkuplist.Enqueue(checkup);
        checkuplist.Enqueue(checkup2);
        checkuplist.Enqueue(checkup3);
        checkuplist.Enqueue(checkup4);
        
        checkuplist.print();
    }
}
