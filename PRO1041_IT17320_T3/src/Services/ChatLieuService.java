/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import java.util.List;
import ViewModels.ChatLieuViewModel;

/**
 *
 * @author Lvh9x
 */
public interface ChatLieuService {

    public String themChatLieu(ChatLieuViewModel cl);

    public String suaChatLieu(ChatLieuViewModel cl);

    public String xoaChatLieu(ChatLieuViewModel cl);

    public List<ChatLieuViewModel> GetAll();
}
