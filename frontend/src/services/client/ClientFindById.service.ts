import { api } from '@/http/api';
import { ClientDTO } from '@/http/response/ClientDTO';
import { AxiosResponse } from 'axios';

export const ClientFindByIdService = async (id: number): Promise<ClientDTO> => {
  const response: AxiosResponse<ClientDTO> = await api.get(`/v1/clients/${id}`);
  return response.data;
};
