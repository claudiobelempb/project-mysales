/*Função que permite apenas numeros*/
export const PERMITIONNUMBER = (value: string) => {
  return value.replace(/\D/g, '');
};
