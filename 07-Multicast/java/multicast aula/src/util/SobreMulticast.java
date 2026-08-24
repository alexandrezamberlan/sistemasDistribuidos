/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;


public class SobreMulticast {
    public static void main(String[] args) {
        StringBuffer texto = new StringBuffer();
        
        texto.append("Multicast é uma técnica de comunicação em Sistemas Distribuídos\n");
        texto.append("Trabalho com a ideia de arquitetura Ponto-a-Ponto em forma de Grupos\n");
        texto.append("Principal protocolo de entrega de pacotes é UDP.... não garante a entrega\n");
        
        texto.append("\n\nEntretanto, se desejarmos garantir entrega de pacotes, é preciso\n"
                + "implementar a arquitetura Cliente-Servidor, em que o servidor guarda\n"
                + "todas as mensagens e as envia posteriormente a todos os integrantes"
                + "do grupo\n");
        
        texto.append("Foco do Multicast é grupo via endereço de classe D - 224..... a 239...");
        
        
        JOptionPane.showMessageDialog(null, texto);
        
        
    }
    
}
