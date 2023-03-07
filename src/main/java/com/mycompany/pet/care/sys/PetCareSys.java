/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pet.care.sys;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author Ramesh
 */

public class PetCareSys {

    public static void MainMenu()
    {
        System.out.println("|| ********* PetClinic ********** ||");
        System.out.println("           ||Main Menu||");
        System.out.println("|| ****************************** ||");
        System.out.println("\nEnter 1 for Insert New Veterinarian");
        System.out.println("Enter 2 for Inset Pet");
        System.out.println("Enter 3 for print all Veterinarian");
        System.out.println("Enter 4 for Print all Pet");
        System.out.println("Enetr 5 for checkup Menu");
        System.out.println("Enter 0 for Exit");
    }
    
    public static void main(String[] args) {
        PetList plist = new PetList();
        VeterinarianList vetlist = new VeterinarianList();
        Scanner s = new Scanner(System.in);

        String choise;
        while (true){
            MainMenu();
            choise = s.nextLine();
            if (choise.equals("1")) {
                System.out.println("Veterinarian  ID");
                String id = s.nextLine();

                System.out.println("Veterinarian  Name");
                String name = s.nextLine();

                System.out.println("Veterinarian  Contact");
                String contact = s.nextLine();

                System.out.println("Veterinarian  Specilaty");
                String specility = s.nextLine();

                System.out.println("Veterinarian  Fee");
                Float fee = s.nextFloat();

                Veterinarian vet = new Veterinarian(id,name,contact,specility, fee); 
                vetlist.Insert(vet);
            }else if (choise.equals("2")) {
                System.out.println("Pet ID");
                String id = s.nextLine();

                System.out.println("Pet Owner Name");
                String name = s.nextLine();

                System.out.println("Pet Owner Contact");
                String contact = s.nextLine();

                Pet pet = new Pet(id, name, contact);
                plist.Insert(pet);

            } else if (choise.equals("3")) {
                vetlist.PrintData();
            } else if (choise.equals("4")) {
                plist.PrintData();
            } else if (choise.equals("5")) {
                
                System.out.println("\n Welcome To CheckUp Menu \n");
                CheckupList[] checkuplist =new CheckupList[vetlist.size()];
        //System.out.println(clist.length)
                for(int i=0;i<checkuplist.length;i++){
                    checkuplist[i]=new CheckupList();
                    Veterinarian vet = vetlist.getIndex(i);
                    System.out.println("\nEnter Patient For  Veterinarian");
                    System.out.println("Name                     :"+vet.getName());
                    System.out.println("Speciality               :"+vet.getSpeciality());
                    System.out.println("Fees                     :"+vet.getFees());
            
                    System.out.println("All Pets :");
                    plist.PrintData();
                    
                    String id;
            
                    while(true){
                        System.out.println("Enter Pet Id or type null to Stop");
                        id = s.nextLine();
             
                        if (id.equals("null")){
                            break;
                        }else{
                            System.out.println("Priority 3 for Emergency 2 for Intermediate any other key for normal ");
                            String per=s.nextLine();
                            int p=1;
            
                            if(per.equals("3")){
                                p=3;
                            }else if(per.equals("2")){
                                p=2;
                            }
                                Pet pet = plist.SearchByID(id);
                            if(pet==null){
                                System.out.println("\nInvalid Patient iD ! \n");
                            }else{
                                Checkup cup = new Checkup(vet,pet,p,"","");
                                checkuplist[i].Enqueue(cup);
                            }
                        }
                    }
                }
                
                /*
                System.out.println("\n Welcome To CheckUp Menu\n");
                CheckupList[] checkuplist = new CheckupList[vetlist.size()];
                
                for (int i=0;i<checkuplist.length;i++){
                    System.out.println("\n\n Pet "+(i+i)+"In Queue For Veterinarian"+VeterinarianList.getIndex(i).getName());
                    for(int j=0;j<checkuplist[i].size();j++){
                        System.out.println("Enter Recomandation for Pet:"+checkuplist[i].getPet(j));

                        String rec=s.nextLine();

                        checkuplist[i].addRecomondation(j, rec);
                    }
                }
                */
                
            }else if (choise.equals("0")){
                break;
            }else{
                System.out.println("\n\n Invalid choise! \n");
            }
        }
    }  
}
