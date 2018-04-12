package in.reqres;

import java.util.List;

@lombok.Data
public class Users {
    private String page;
    private String per_page;
    private String total;
    private String total_pages;
    private List<in.reqres.Data> data;

}
