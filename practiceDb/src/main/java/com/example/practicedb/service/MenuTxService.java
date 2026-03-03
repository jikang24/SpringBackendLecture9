package com.example.practicedb.service;

import com.example.practicedb.domain.Menu;
import com.example.practicedb.exception.MenuCheckedException;
import com.example.practicedb.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@RequiredArgsConstructor
public class MenuTxService {
  private final MenuRepository menuRepository;

  // 1) 언체크 예외 -> 기본 롤백
  @Transactional
  public void updateThenRuntimeRollback(Long menuId, int newPrice) {
    Menu menu = menuRepository.findById(menuId).orElseThrow();
    menu.changePrice(newPrice);

    throw new MenuCheckedException("런타임 예외 발생 -> 롤백 기대");
  }

  // 2) 체크 예외 -> 기본은 커밋(롤백 안 함)
  @Transactional
  public void updateThenCheckedCommit(Long menuId, int newPrice) {
    Menu menu = menuRepository.findById(menuId).orElseThrow();
    menu.changePrice(newPrice);

    throw new MenuCheckedException("체크 예외 발생 -> 기본 정책이면 커밋될 수 있음");
  }

  // 3) 체크 예외여도 rollbackFor로 롤백되게
  @Transactional(rollbackFor = MenuCheckedException.class)
  public void updateThenCheckedRollback(Long menuId, int newPrice) throws MenuCheckedException{
    Menu menu = menuRepository.findById(menuId).orElseThrow();
    menu.changePrice(newPrice);

    throw new MenuCheckedException("체크 예외지만 rollBackFor로 롤백");
  }

  // 4) RuntimeException인데 noRollbackFor로 커밋되게
  @Transactional(noRollbackFor = IllegalArgumentException.class)
  public void updateThenNoRollbackFor(Long menuId, int newPrice) {
    Menu menu = menuRepository.findById(menuId).orElseThrow();
    menu.changePrice(newPrice);

    throw new IllegalArgumentException("기본은 롤백 대상이지만 noRollbackFor로 커밋 기대");
  }

  // 5) try-catch로 예외를 삼켜서 커밋되는 상황 재현
  @Transactional
  public void updateThenSwallowExceptionCommit(Long menuId, int newPrice){
    Menu menu = menuRepository.findById(menuId).orElseThrow();
    menu.changePrice(newPrice);

    try{
      throw new RuntimeException("예외 발생");
    }catch (Exception e){
    }
  }

  // 6) try-catch로 삼키더라도 setRollbackOnly로 롤백시키기
  @Transactional
  public void updateThenSwallowButRollback(Long menuId, int newPrice){
    Menu menu = menuRepository.findById(menuId).orElseThrow();
    menu.changePrice(newPrice);

    try {
      throw new RuntimeException("예외 발생");
    }catch (Exception e){
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
  }

}
