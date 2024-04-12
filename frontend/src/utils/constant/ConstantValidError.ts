type ConstantValidationErrorType = {
  required: string;
  moreThan: string;
  size: (value: number) => string;
  min: (value: number) => string;
  max: (value: number) => string;
};

export const ConstantValidationError: ConstantValidationErrorType = {
  required: 'Este campo e obrigatório!',
  moreThan: 'Valor de ser maior que 0,00 (Zero)!',
  size: (value: number) =>
    `a descrição deve ter exatamente ${value} caracteres`,
  min: (value: number) => `a descrição deve ter pelo menos ${value} caracteres`,
  max: (value: number) => `a descrição deve ter no máximo ${value} caracteres`
};
