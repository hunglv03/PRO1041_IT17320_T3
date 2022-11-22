/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Reponsitories.ChatLieuRepository;
import Services.ChatLieuService;
import ViewModels.ChatLieuViewModel;
import java.util.List;



/**
 *
 * @author Lvh9x
 */
public class ChatLieuServiceImpl implements ChatLieuService {

    private ChatLieuRepository chatLieuRepo = new ChatLieuRepository();

    @Override
    public String themChatLieu(ChatLieuViewModel cl) {
        if (chatLieuRepo.Add(cl)) {
            return "Thêm thành công";
        }
        return "Thêm không thành công";
    }

    @Override
    public String suaChatLieu(ChatLieuViewModel cl) {
        if (chatLieuRepo.Update(cl)) {
            return "Sửa thành công";
        }
        return "Sửa không thành công";
    }

    @Override
    public String xoaChatLieu(ChatLieuViewModel cl) {
        if (chatLieuRepo.Delete(cl)) {
            return "Xóa thành công";
        }
        return "Xóa không thành công";
    }

    @Override
    public List<ChatLieuViewModel> GetAll() {
        return chatLieuRepo.GetAll();
    }

}
