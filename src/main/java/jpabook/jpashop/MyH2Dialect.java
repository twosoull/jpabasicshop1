package jpabook.jpashop;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyH2Dialect extends H2Dialect {

    //function 등록
    public MyH2Dialect() {
        registerFunction("group_concat",new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
    }
}
