/*Função que padroniza DATA*/
export const MASKHORA = (value: string) => {
  value = value.replace(/\D/g, '');
  value = value.replace(/(\d{2})(\d)/, '$1:$2');
  return value;
};

/*Função que padroniza DATA*/
export const MASKDATE = (value: string) => {
  value = value.replace(/(\d{2})(\d)/, '$1/$2');
  value = value.replace(/(\d{2})(\d)/, '$1/$2');
  return value;
};

export const MASKDATEBIRTH = (data: string) => {
  data = data.replace(/\D/g, '');
  data = data.replace(/(\d{2})(\d)/, '$1/$2');
  data = data.replace(/(\d{2})(\d)/, '$1/$2');
  return data;
};
