public class LinkedList implements HW2Interface
{
    
    DoubleLinkNode head = null;
    DoubleLinkNode tail = null;
    
    int LinkedList_length = 0;
    
    @Override
    public void Insert(int newElement, int pos) throws Exception
    {
        DoubleLinkNode newNode = new DoubleLinkNode();
        
        newNode.Element = newElement;
        newNode.left = null;
        newNode.right = null;
        
        
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        
        else if(pos == 0)
        {
            newNode.right = head;
            head.left = newNode;
            newNode.left = null;
            head = newNode;
        }
        
        else if(pos == LinkedList_length)
        {
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        }
        
        else
        {
            int acc = 0;
            DoubleLinkNode temp;
            temp = head;
            
            while(true)
            {
                if (temp.right != null && acc != pos-1)
                {
                    acc++;
                    temp = temp.right;
                }
                
                else if(temp.right != null && acc == pos-1)
                {
                    newNode.right = temp.right;
                    temp.right = newNode;
                    newNode.left = temp;
                    newNode.right.left = newNode;
                    break;
                }
                else
                {
                    throw LinkedListException();
                }
            }
        }
        
        LinkedList_length++;
    }

    @Override
    public int Delete(int pos) throws Exception
    {
        int willReturnNumber = 0;
        DoubleLinkNode temp = new DoubleLinkNode();
        temp = head;
        
        int numberOfElements = 0;
        while(temp != null)
        {
            numberOfElements++;
            temp = temp.right;
        }
        
        temp = head;
        
        if(head == null){throw LinkedListException();}
        
        else if(pos > numberOfElements){throw LinkedListException();}
        
        else if(pos == 0)
        {
            head = head.right;
        }
        
        else
        {
            int acc=0;
            
            while(true)
            {
                if(acc<pos)
                {
                    acc++;
                    temp = temp.right;
                }
                else
                {
                    temp.left.right = temp.right;
                    temp.right.left = temp.left;
                    willReturnNumber = temp.Element;
                    break;
                }
            }
            
        }
        return willReturnNumber;
    }

    @Override
    public void LinkReverse()
    {
        DoubleLinkNode temp;
        temp = head;
        
        DoubleLinkNode headTemp;
        DoubleLinkNode tailTemp;
        headTemp = head;
        tailTemp = tail;
        
        int numberOfElements = 0;
        while(temp != null)
        {
            numberOfElements++;
            temp = temp.right;
        }
        
        int acc = 0;
        int tempInt;
        
        while(acc < (int)(numberOfElements / 2))
        {
            tempInt = tailTemp.Element;
            tailTemp.Element = headTemp.Element;
            headTemp.Element = tempInt;
            
            headTemp = headTemp.right;
            tailTemp = tailTemp.left;
            
            acc++;
        }
    }

    @Override
    public void SacuraL() 
    {
        DoubleLinkNode temp;
        temp = head;
        
        int[] tempArray = new int[50];
        
        int k =0;
        while(temp != null)
        {
            int acc = 1;
            while((temp.right != null) && (temp.Element == temp.right.Element))
            {
                acc++;
                temp = temp.right;
            }
            tempArray[k] = temp.Element;
            tempArray[k+1] = acc;
            k+=2;
            temp = temp.right;
            
        }
        
        int array_len = 0;
        for(int m=0; m<tempArray.length; m++)
        {
            if(tempArray[m] > 0)
            {
                array_len++;
            }
        }
        
        int[] array = new int[array_len];
        
        for (int n=0; n<array_len;n++)
        {
            array[n] = tempArray[n]; 
        }
        
        temp = head;
        int numberOfElements = 0;
        
        while(temp != null)
        {
            numberOfElements++;
            temp = temp.right;
        }
        
        temp = head;
        int index = 0;
        int p = 0;
        while(index < array_len)
        {
            if(index < numberOfElements)
            {
                temp.Element = array[index];
                temp = temp.right;
                index++;
            }
            else
            {
                try
                {
                    Insert(array[index],numberOfElements + p);
                    p++;
                    index++;
                }
                catch (Exception s) 
                {
                    System.out.println(s.toString());
                }       
            }   
        }
    }

    @Override
    public void OpacuraL() 
    {
        DoubleLinkNode temp;
        temp = head;
        
        String tempElementsString = "";
        
        while(temp != null)
        {
            for(int i=0; i< temp.right.Element; i++)
            {
                tempElementsString += temp.Element;
            }
            temp = temp.right.right;
        }
        head = null;
        tail = null;
        LinkedList_length = 0;
        
        int len = tempElementsString.length();
        
        for(int p=0; p<len;p++)
        {
            try 
            {
                Insert(Integer.parseInt(tempElementsString.substring(p,p+1)), p);
            } 
            catch (Exception ex) 
            {
                ex.toString();
            }
        }
    }

    @Override
    public void Output() 
    {
        DoubleLinkNode temp = new DoubleLinkNode();
        temp = head;
        System.out.print("The Elements in the list are : ");
        while(temp != null)
        {
            System.out.print(temp.Element +" ");
            temp = temp.right;
        }
    }

    @Override
    public void ReverseOutput() 
    {
        DoubleLinkNode temp = new DoubleLinkNode();
        temp = head;
        
        int numberOfElements = 0;
        while(temp != null)
        {
            numberOfElements++;
            temp = temp.right;
        }
        
        int[] elementsList = new int[numberOfElements];
        
        temp = head;
        
        int acc = 0;
        while(temp != null)
        {
            elementsList[numberOfElements-acc-1] = temp.Element;
            temp = temp.right;
            acc++;
        }
        
        System.out.print("The Reverse Elements in the list are : ");
        
        for(int i=0; i<elementsList.length; i++)
        {
            System.out.print(elementsList[i] + " ");
        }
    }
    
    @Override
    public String toString()
    {
        String result = "";
        
        DoubleLinkNode temp = new DoubleLinkNode();
        temp = head;
        
        while(temp != null)
        {
            result += temp.Element + " "; 
            temp = temp.right;
        }
        
        return result;
    }

    @Override
    public Exception LinkedListException() 
    {
        return new Exception("Exception blok calisti!");
    }
    
}
