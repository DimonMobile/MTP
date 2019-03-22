package by.belstu.it.potnikov.basejava;

import java.util.Objects;

/**
 * @author d.plotnikov
 * @version 1.0.0
 *
 */

public class WrapperString
{
    public void replace(char oldchar, char newchar) {
        StringBuilder sb = new StringBuilder(string);
        for(int i = 0 ; i < sb.length(); ++i)
            if (sb.charAt(i) == oldchar)
                sb.setCharAt(i,newchar);
        string = sb.toString();
    }

    public WrapperString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "string='" + string + '\'' +
                '}';
    }

    private String string;
}