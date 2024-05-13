export type ClientDTO = {
  id: number;
  name: string;
  email: string;
  cpf: string;
  birth: String;
  address: string;
  teleohone: string;
  createdAt: string;
};

export type ClientFormDTO = Omit<ClientDTO, 'id' | 'createdAt'>;
