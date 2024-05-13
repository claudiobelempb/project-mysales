import { api } from '@/http/api';
export const ClientDeleteService = async (id: number): Promise<void> => {
  await api.delete(`/v1/clients/${id}`);
};
