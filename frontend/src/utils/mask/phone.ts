/*Função que padroniza telefone (11) 4184-1241*/
export const MASKPHONE = (value: string) => {
  value = value.replace(/\D/g, '');
  value = value.replace(/^(\d\d)(\d)/g, '($1) $2');
  value = value.replace(/(\d{4})(\d)/, '$1-$2');
  return value;
};

/*Função que padroniza telefone (11) 41841241*/
function MASKPHONECALL(v: string) {
  v = v.replace(/\D/g, '');
  v = v.replace(/^(\d\d)(\d)/g, '($1) $2');
  return v;
}
