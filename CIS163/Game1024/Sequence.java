package game1024;

public class Sequence 
{
    public int[] numbers;

    public Sequence(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean equals(Sequence s) {
        if (this.numbers.length != s.numbers.length) {
            return false;
        }

        for (int n = 0; n < s.numbers.length; n++) {
            if (this.numbers[n] != s.numbers[n]) {
                return false;
            }
        }

        return true;
    }

    public boolean equals( Object s )
    {
        if (s instanceof Sequence)
        {
            return this.equals( (Sequence) s );
        }
        else
        {
            return false;
        }
    }

    public int[] reverse() {

        int[] helper = new int[this.numbers.length];

        for (int n = 0; n < this.numbers.length; n++) {
            helper[n] = this.numbers[this.numbers.length - 1 - n];
        }
        return helper;
    }

    public int[] slideLeft() {
        int[] helper = new int[this.numbers.length];
        int x = 0;
        for (int n = 0; n < this.numbers.length; n++) {
            if (this.numbers[n] > 0) {
                helper[x] = this.numbers[n];
                x++;
            }
        }
        return helper;
    }

    public int[] combineLeft1024() {
        Sequence s = new Sequence( this.numbers );
        s.numbers = s.slideLeft();
        for (int j = 0; j < s.numbers.length-1; j++) {
            if (s.numbers[j] == s.numbers[j + 1]) {
                s.numbers[j] += s.numbers[j + 1];
                s.numbers[j + 1] = 0;
            }
        }

        return s.slideLeft();
    }

    public int[] combineRight1024()
    {
        Sequence s = new Sequence( this.numbers );        
        s.numbers = s.reverse();
        s.numbers = s.combineLeft1024();
        return s.reverse();
    }

    // -----------    
    // also works
    // -----------    
    //    public int[] combineRight1024()
    //    {
    //        return this.inReverse().combinedLeftJustified().inReverse().numbers;
    //    }

    public String toString() {
        
        String str = "  ";
        for (int n = 0; n < this.numbers.length; n++) {
            str += this.numbers[n] + ", ";
        }
        return str.substring(0, str.length() - 2);
    }
}
