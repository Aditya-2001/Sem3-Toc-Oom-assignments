class Test
{
    boolean flag;

    public Test(boolean flag)
    {
        this.flag = flag;
    }
    public void printbar()
    {
        for( int i = 2; i <= 10; i++ )
        {
            synchronized (this)
            {
                try
                {
                    while( !flag )
                        wait();
                    System.out.println("bar");
                    flag = false;
                    notify();
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void printfoo()
    {
        for( int i = 1; i < 10; i++ )
        {
            synchronized (this)
            {
                try
                {
                    while(flag )
                        wait();
                    System.out.println("foo");
                    flag = true;
                    notify();
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

		public static void main(String[] args)
		{
            
		}
}

public class Main {
    public static void main(String [] args)
    {
        Test t = new Test(false);
        Thread t1 = new Thread( new Runnable() {
           public void run()
           {
               t.printfoo();
           }
        });
        Thread t2 = new Thread( new Runnable() {
            public void run()
            {
                t.printbar();
            }
        });
        t1.start();
        t2.start();
    }
}