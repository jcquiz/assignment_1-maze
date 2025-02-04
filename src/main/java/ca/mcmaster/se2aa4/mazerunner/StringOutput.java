package ca.mcmaster.se2aa4.mazerunner;

// responsible for tracking canonical string and compressing it into factorized

public class StringOutput 
{
    private StringBuffer s = new StringBuffer();
    private StringBuffer f = new StringBuffer();

    public void appendString(char c)
    {
        s.append(c);
    }

    public String returnCanonical()
    {
        String canonical = s.toString();
        return canonical;
    }

    public String factorizedOutput()
    {
        String canonical = returnCanonical();
        int count = 0;
        char current_char = 'z'; // placeholder char

        for(int i=0; i < canonical.length(); i++)
        {
            if (i == 0) // sets first character to the current_char and increments
            {
                current_char = canonical.charAt(i);
                count++;
            }
            else
            {
                if(canonical.charAt(i) == current_char) // same char increments count
                {
                    count++;
                }
                else // not same char adds the number of that consecutive char to the StringBuffer
                {
                    f.append(String.valueOf(count) + current_char + " ");
                    current_char = canonical.charAt(i);
                    count = 1;
                }
            }
        }
        f.append(String.valueOf(count) + current_char + " "); // appends the last number of chars, not appended as for loop ends
        return f.toString();
    }


}
