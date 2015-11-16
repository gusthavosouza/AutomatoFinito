# AutomatoFinito

Código escrito para resolução das seguintes expreções regulares.

Real expoente = (0...9) (0...9)*.((0...9)(0...9)*)?(e (+|-)?

(0...9) (0...9)*)? (f|d)?

Real Ponto = .(0...9)(0...9)*(e (+|-)?(0...9)(0...9)* )? (f|d)?

Real = (0...9) (0...9)* (e (+|-)? (0...9) (0...9)*)? (f|d)?

## Automato Finito

<img src="https://raw.githubusercontent.com/gusthavosouza/AutomatoFinito/9d8d2f7c2821af240a030ea1b85c79d3557f52f4/img/automato.jpg"> </img>

### Estados
E = {Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8}
### Valores
V = {0...9, e, . , +, -, f , d}
### Estados Finais
F = {Q1, Q3, Q4, Q5, Q8}



