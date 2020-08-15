package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista( String nome, int idade, int pontos, String habilitacao ) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Motorista motorista = ( Motorista ) o;
        return Objects.equals( habilitacao, motorista.habilitacao );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( habilitacao );
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome( String nome ) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade( int idade ) throws IllegalArgumentException {
            if ( idade > 0 ) {
                this.idade = idade;
            } else {
                throw new IllegalArgumentException( "The IDADE field needs to be greater than 0" );
            }
            return this;
        }

        public MotoristaBuilder withPontos( int pontos ) throws RuntimeException {
            if ( pontos > 0 ) {
                if ( pontos < 20 ) {
                    this.pontos = pontos;
                } else {
                    throw new EstacionamentoException(
                            String.format( "The PONTOS field can't be greater than %d", 20 )
                    );
                }
            } else {
                throw new IllegalArgumentException(
                        String.format( "The PONTOS field needs to be greater than %d", 0 )
                );
            }
            return this;
        }

        public MotoristaBuilder withHabilitacao( String habilitacao ) {
            this.habilitacao = habilitacao;
            return this;
        }

        public Motorista build() throws NullPointerException {
            if ( habilitacao == null ) throw new NullPointerException( "The HABILITACAO field can't be null" );
            if ( nome == null ) throw new NullPointerException( "The NOME field can't be null" );

            return new Motorista( nome, idade, pontos, habilitacao );
        }
    }
}
