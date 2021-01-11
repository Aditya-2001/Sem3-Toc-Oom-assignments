class Test
{
    boolean flag;

    public Test(boolean flag)
    {
        this.flag = flag;
    }
    public void printEven()
    {
        for( int i = 2; i <= 10; i+=2 )
        {
            synchronized (this)
            {
                try
                {
                    while( !flag )
                        wait();
                    System.out.println(i);
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
    public void printOdd()
    {
        for( int i = 1; i < 10; i+=2 )
        {
            synchronized (this)
            {
                try
                {
                    while(flag )
                        wait();
                    System.out.println(i);
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
			//do nothing
		}
}

public class Main {
    public static void main(String [] args)
    {
        Test t = new Test(false);
        Thread t1 = new Thread( new Runnable() {
           public void run()
           {
               t.printOdd();
           }
        });
        Thread t2 = new Thread( new Runnable() {
            public void run()
            {
                t.printEven();
            }
        });
        t1.start();
        t2.start();
    }
}