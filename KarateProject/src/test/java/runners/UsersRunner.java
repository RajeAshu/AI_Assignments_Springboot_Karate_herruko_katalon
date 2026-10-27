package runners;

import com.intuit.karate.junit5.Karate;

public class UsersRunner {

//    @Karate.Test
//    Karate runUsers() {
//        return Karate.run("classpath:features/users.feature");
//    }

    @Karate.Test
    Karate runUsers() {
        return Karate.run("classpath:features/usersJSONData.feature");
    }

}


