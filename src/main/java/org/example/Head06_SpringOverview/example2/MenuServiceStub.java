package org.example.Head06_SpringOverview.example2;

import java.util.List;

public class MenuServiceStub implements MenuService{
    @Override
    public List<String> getMenuList(){
        return List.of("샘플커피1", "샘플커피2");
    }
}
