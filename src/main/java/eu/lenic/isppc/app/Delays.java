package eu.lenic.isppc.app;

public class Delays {

    public long persec;
    public long t;

    public Delays() {
        persec = 1000000;
        //{QueryPerformanceFrequency(persec);}
    }

    public static void WaitS(long period) {
        try {
            Thread.sleep(1000 * period);
        } catch (InterruptedException e) {
        }

    }


    public static void WaitMS(long period) {
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
        }
    }

    public void WaitUS(long period) {
        //int ms = new DateTime().getMillisOfSecond() ;

        long f1 = 0, f2 = 0, c;


        // np 2000us = 2ms => 1000*1000*1000 * 2000 / 1000000;
        // 2000 00
//        p* 1000*1*1 / 1

        f1 = System.nanoTime();
        c = f1 + (this.persec * period) / 1000000;
        if (c == f1) {
            System.out.println("wchodzę tu");
            c = f1 + 1;
            do {
                f2 = System.nanoTime();
            } while (f2 > c);
        } else
        {
            System.out.println("nie wchodzę tu");
        }
    }

    public static void WaitNS(long time) {
//        procedure WaitNS(x:integer);
//        var
//        f1,f2,c:Int64;
//        begin
//        f1:=0; f2:=0;
//        {QueryPerformanceCounter(f1);}
//        c:=f1+(persec*x) div 1000000000;
//        if c = f1 then
//        c:=f1 + 1;
//        repeat
//        {QueryPerformanceCounter(f2);}
//        until f2>=c;
//        end;
    }

    public void Tic(long time) {
        this.t = System.nanoTime();
    }

    public long TicMS(long time) {
        long current = System.nanoTime();
        return ((current - this.t) * 1000) % this.persec;
    }

    public long TicUS(long time) {
        long current = System.nanoTime();
        return ((current - this.t) * 1000000) / this.persec;
    }

    public long TicNS(long time) {
        long current = System.nanoTime();
        return ((current - this.t) * 1000000000) / this.persec;
    }
}