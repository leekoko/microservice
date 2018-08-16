# SpringBoot进阶    

### 表单验证

M：我不想让一些不符合的数据插入数据库，前端控制虽然可以防止小白误操作，但是有意的黑客是可以很容易就绕过前端验证控制的，怎么在后台代码上验证数据呢？

Z：添加@Valid注解    

1. 首先将传值改为传对象，然后在对象前面添加@Valid注解。而BindingResult是用来存储报错信息的。

   ```java
       /**
        * 添加内容
        */
       @PostMapping(value = "/girlAdd")
       public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
           if(bindingResult.hasErrors()){
              //如果存在报错，输出报错信息
               System.out.println(bindingResult.getFieldError().getDefaultMessage());
               return null;
           }
           return girlRepository.save(girl);
       }
   ```

M：那怎么进行限制并报错呢？

Z：在``@Valid``的对象里面，``@Min``限定的是最小的值，如果小于value值，message值将写入BindingResult中。   

```java   
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String size;

    @Min(value = 18,message = "不到18不能进")
    private Integer age;
...
```

### AOP   



















































https://www.imooc.com/learn/810