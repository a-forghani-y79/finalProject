package sample.DataCenter;


// یه کلاس برای اضافه کردن دانشجو های جدید از فایل CSV
// که از سازمان سنجش دریافت شده است
//سازنده یا contractor کلاس فقط آدرس فایل CSV و آدرس فایل باینری مقصد رو خواهد گرفت
// و با متد import کار خود را انجام داده و تمام
public class ImportNewStudent {


    private String CSV_addr ;
    private String Bin_addr ;

    ImportNewStudent(String CSV_address, String Binary_address) {
    this.CSV_addr = CSV_address;
    this.Bin_addr = Binary_address;
    }


}
