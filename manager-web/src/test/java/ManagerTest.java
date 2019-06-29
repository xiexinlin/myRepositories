import com.xiedapao.mapper.UsersMapper;
import com.xiedapao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class ManagerTest {
    @Autowired
    private UsersMapper usersMapper;
    @Test
    public void InsertTest(){
        User users = new User();
        users.setAge("18");
        users.setUsername("谢大炮");
        usersMapper.insertUser(users);
    }
}
