package cn.leekoko.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setSize("A");
        girlA.setAge(10);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setSize("B");
        girlB.setAge(20);
        girlRepository.save(girlB);
    }



}
