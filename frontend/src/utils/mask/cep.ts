/*Função que padroniza CEP*/
export const MASKCEP = (value: string) => {
  value = value.replace(/D/g, '');
  value = value.replace(/^(\d{5})(\d)/, '$1-$2');
  return value;
};
