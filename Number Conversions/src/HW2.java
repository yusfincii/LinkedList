public class HW2 
{
    public static void main(String[] args) 
    {
        LinkedList myList = new LinkedList();
        
        try
        {
            myList.Insert(1, 0);
            myList.Insert(2, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(9, 5);
            myList.Insert(9, 6);
            myList.Insert(1, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(3, 0);
            myList.Insert(2, 0);
            myList.Insert(5, 54);
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.toString());
        }
        myList.Output();
        System.out.println("");
        
        myList.LinkReverse();
        myList.Output();
        System.out.println("");
        
        myList.SacuraL();
        myList.Output();
        System.out.println("");
        
        myList.OpacuraL();
        myList.Output();
        System.out.println("");
        
        myList.ReverseOutput();
        System.out.println("");
        System.out.println(myList);
        
        System.out.println("");
        
        try 
        {
            myList.Delete(25);
        }
        catch (Exception ex) 
        {
            System.out.println(ex.toString());
        }
        
        myList.Output();
        
        System.out.println();
        
        System.out.println(myList.toString());
    }
}

