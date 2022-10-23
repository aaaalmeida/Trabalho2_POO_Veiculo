public enum QtdParcela {
    X1(1), X2(2), X4(4), X6(6), X12(12), X24(24);

    private final int valor;

    QtdParcela(int valor) {
        this.valor = valor;
    }

    public int getQtdParcelas() {
        return valor;
    }
}