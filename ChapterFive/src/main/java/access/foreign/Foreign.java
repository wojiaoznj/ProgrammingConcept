package access.foreign;

import access.local.PackagedClass;

/**
 * @author ZNJ
 * @create 2019-02-14 15:07
 */
public class Foreign {
    public static void main(String [] args){
        //如果PackagedClass类是默认访问修饰符，则创建语句会报错
        PackagedClass pc=new PackagedClass();
    }
}
