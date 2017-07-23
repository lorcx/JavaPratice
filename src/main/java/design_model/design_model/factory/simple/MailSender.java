package design_model.factory.simple; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 上午09:55:07
 * @Author:李欣
 * @Version:1.0
 */

public class MailSender implements Sender {  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  
