package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.util.Pager;

@Service
public class BankBookCommentService implements BbsService {

   @Autowired
   private BbsDAO bankbookCommentDAO;
   //private BankbookCommentDAO bankbookCommentDAO;
   
   
   @Override
   public List<BbsDTO> getBoardList(Pager pager) throws Exception {
      pager.makeRow();
      Long totalCount = bankbookCommentDAO.getTotalCount(pager);
      pager.makeBlock(totalCount);
      return bankbookCommentDAO.getBoardList(pager);
   }

   @Override
   public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
      // TODO Auto-generated method stub
      return 0;
   }
   
}