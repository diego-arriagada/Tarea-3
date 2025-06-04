package org.tarea3;

public class Wallet{
    private Deposito<Moneda> deposito;
    private int ValorWallet;

    public Wallet(){
        this.ValorWallet = 0;
        Deposito<Moneda> deposito = new Deposito<Moneda>();

    }

    public int getvalorWallet(){
        this.ValorWallet = 0;
        for(int i=0;i<deposito.deposito.size();i++){
            this.ValorWallet = ValorWallet + deposito.deposito.get(i).getValor();
        }
        return this.ValorWallet;
    }

    public Moneda obtenerMoneda(int valor){
        for(int i=0;i<deposito.deposito.size();i++){
            if(deposito.deposito.get(i).getValor() == valor){
                return deposito.deposito.remove(i);
            }
        }
        return null;
    }

    public void vaciarWallet(){
        for(int i=0;i<deposito.deposito.size();i++){
            deposito.deposito.removeFirst();
        }
    }


    public void addMoneda(Moneda m){
        deposito.addObjeto(m);
    }

}
