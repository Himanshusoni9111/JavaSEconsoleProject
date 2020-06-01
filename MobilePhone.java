package Practice;

import java.util.ArrayList;

public class MobilePhone
{
    private String mynumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String mynumber)
    {
this.mynumber=mynumber;
this.myContact= new ArrayList<Contact>();
    }

    public boolean addNewcontact(Contact contact)
    {
        if(findContact(contact.getName())>=0)
        {
            System.out.println("contact is already in file");
            return false;

            }
            myContact.add(contact);
        return true;
        }

        private int findContact(Contact contact)
        {
            return this.myContact.indexOf(contact);
        }


        private int findContact(String contactName)
        {
            for(int i=0;i<this.myContact.size();i++)
            {
                Contact contact =this.myContact.get(i);

                if(contact.getName().equals(contactName))
                {
                    return i;
                }
            } return -1;
        }


    public void storeContacts()
    {

    }
    public boolean modifycontact(Contact oldcontact,Contact newcontact)
    {
        int foundposition = findContact(oldcontact);
        if(foundposition < 0)
        {
            System.out.println(oldcontact.getName()+ ",was not found.");
            return false;
        }
        else
            if (findContact(newcontact.getName())!= -1){
            System.out.println("Contact with name :"+newcontact.getName()+"already Exists");
return false;
    }
        this.myContact.set(foundposition,newcontact);
        System.out.println(oldcontact.getName()+", was replaced with "+newcontact.getName());
        return true;

    }
    public boolean removecontact(Contact contact)
    {
        int foundposition = findContact(contact);
        if(foundposition < 0)
        {
            System.out.println(contact.getName()+ ",was not found.");
            return false;
        }
        this.myContact.remove(foundposition);
        System.out.println(contact.getName()+"was deleted.");
    return true;
    }
    public String query(Contact contact)

    {
if(findContact(contact)>=0)
    {
    return contact.getName();
    }
    return null;
    }
    public Contact query(String name)
    {
        int position = findContact(name);
        if(position>=0)
        {
            return this.myContact.get(position);
        }
        return null;

    }
    public void printContacts()
    {
        System.out.println("the list of contact is\n"+
                "");
        for(int i=0;i<this.myContact.size();i++)
        {
            System.out.println((i+1)+" . "+this.myContact.get(i).getName()+" --> "+this.myContact.get(i).getNumber());
        }
    }
    }

