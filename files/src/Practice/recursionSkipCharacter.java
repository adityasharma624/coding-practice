package Practice;

import javax.xml.transform.Source;

public class recursionSkipCharacter {
    static void main() {
        skip("","aditya");
        skipApple("", "adiappletya");
        skipOthers("", "adiappletya");
    }


    // skip if not the required string
    static void skipOthers(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.println(p);
            return;
        }

        if (up.startsWith("apple"))
        {
            skipOthers(p + "apple", up.substring(5));
        }
        else
        {
            skipOthers(p, up.substring(1));
        }
    }


    // skip 'a'
    static void skip(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.println(p);
            return;
        }

        if (up.charAt(0) == 'a')
        {
            skip(p, up.substring(1));
        }
        else
        {
            skip(p + up.charAt(0), up.substring(1));
        }
    }


    // skip a particular string
    static void skipApple(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.println(p);
            return;
        }

        if (up.startsWith("apple"))
        {
            skipApple(p, up.substring(5));
        }
        else
        {
            skipApple(p + up.charAt(0), up.substring(1));
        }
    }
}
