import { api } from '@/http/api';
import { ClientDTO, ClientFormDTO } from '@/http/response/ClientDTO';
import { AxiosResponse } from 'axios';

export const ClientFindAllService = async (
  client: ClientFormDTO
): Promise<ClientDTO> => {
  const response: AxiosResponse<ClientDTO> = await api.put(
    `/v1/clients`,
    client
  );
  return response.data;
};
