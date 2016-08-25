package jain.myapplication.model;

/**
 * Created by harsh on 12-Aug-16.
 */
public class Availability
{
    private String status;

    private String date;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", date = "+date+"]";
    }
}
