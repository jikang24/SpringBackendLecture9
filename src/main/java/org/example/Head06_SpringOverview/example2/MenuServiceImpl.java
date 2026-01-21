package org.example.Head06_SpringOverview.example2;

import java.util.List;

public class MenuServiceImpl implements MenuService{
    @Override
    public List<String> getMenuList(){
        return List.of("아메리카노", "카페라떼");
    }
}
