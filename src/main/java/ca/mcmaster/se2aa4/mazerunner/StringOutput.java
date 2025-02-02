package ca.mcmaster.se2aa4.mazerunner;

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
        char current_char = 'z';

        for(int i=0; i < canonical.length(); i++)
        {
            if (i == 0) 
            {
                current_char = canonical.charAt(i);
                count++;
            }
            else
            {
                if(canonical.charAt(i) == current_char)
                {
                    count++;
                }
                else // not same char
                {
                    f.append(String.valueOf(count) + current_char + " ");
                    current_char = canonical.charAt(i);
                    count = 1;
                }
            }
        }
        f.append(String.valueOf(count) + current_char + " ");
        
        return f.toString();
    }


}
