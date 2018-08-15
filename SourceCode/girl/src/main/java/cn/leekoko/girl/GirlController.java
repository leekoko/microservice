package cn.leekoko.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping(value = "/girlById/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        Optional<Girl> temp = girlRepository.findById(id);
        //从返回值中获取值
        return temp.get();
    }

    /**
     * 添加内容
     * @param age
     */
    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@RequestParam("size") String size, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setSize(size);
        return girlRepository.save(girl);
    }

    /**
     * 更新
     */
    @PutMapping(value = "/moGirlById/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("age") Integer age,@RequestParam("size") String size) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setSize(size);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/delGirls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        Girl girl = new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
    }

    /**
     * 通过年龄查询
     */
    @GetMapping(value = "/girlByAge/{age}")
    public List<Girl> getListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 测试事务：插入两条数据
     */
    @PostMapping(value = "/girl/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

}
